package com.megaeyes.service.utils.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SocketChannel;
import java.util.Random;

/**
 * 全球眼标准协议发送工具
 * 
 * @author HBJ <br />
 *         create at 2011-1-17 下午02:33:09
 */
public class MegaSocketClient {

	public static final int DEFAULT_VERSION = 257;
	public static final byte EMPTY = 0;
	public static final int BUFFER_SIZE = 4096;

	private int version; // 版本号
	private int number; // 指令号
	private int seq; // 指令序号
	private String sourceId; // 源ID
	private String destId; // 目标ID
	private String content; // 数据内容
	private String ip; // 接收端IP
	private int port; // 接收端端口

	/**
	 * 构造方法，完整版
	 * 
	 * @param version
	 *            版本号
	 * @param number
	 *            指令号
	 * @param seq
	 *            指令序号
	 * @param sourceId
	 *            源ID
	 * @param destId
	 *            目标ID
	 * @param content
	 *            数据内容
	 * @param ip
	 *            接收端IP
	 * @param port
	 *            接收端端口
	 */
	public MegaSocketClient(int version, int number, int seq, String sourceId,
			String destId, String content, String ip, int port) {
		this.version = version;
		this.number = number;
		this.seq = seq;
		this.sourceId = sourceId;
		this.destId = destId;
		this.content = content;
		this.ip = ip;
		this.port = port;
	}

	/**
	 * 构造方法，简化版，默认257版本号，和自动随机生成指令序号
	 * 
	 * @param number
	 *            指令号
	 * @param sourceId
	 *            源ID
	 * @param destId
	 *            目标ID
	 * @param content
	 *            数据内容
	 * @param ip
	 *            接收端IP
	 * @param port
	 *            接收端端口
	 */
	public MegaSocketClient(int number, String sourceId, String destId,
			String content, String ip, int port) {
		this.version = DEFAULT_VERSION;
		this.number = number;
		this.seq = new Random().nextInt(32767);
		this.sourceId = sourceId;
		this.destId = destId;
		this.content = content;
		this.ip = ip;
		this.port = port;
	}

	/**
	 * 发送不带返回
	 */
	public void send() {
		SocketChannel channel = null;
		try {
			byte[] data = content != null ? this.content.getBytes("utf8")
					: new byte[0];
			byte[] source = sourceId != null ? sourceId.getBytes("utf8")
					: new byte[0];
			byte[] dest = destId != null ? destId.getBytes("utf8")
					: new byte[0];

			InetSocketAddress socketAddress = new InetSocketAddress(ip, port);
			channel = SocketChannel.open(socketAddress);

			ByteBuffer headBuffer = ByteBuffer.allocate(80 + data.length);
			headBuffer.order(ByteOrder.LITTLE_ENDIAN);
			headBuffer.putInt(version); // 版本号
			headBuffer.putInt(data.length); // 指令长度
			headBuffer.putInt(number); // 指令编号
			headBuffer.putInt(seq); // 指令序号
			headBuffer.put(source); // 源ID
			// 补充到32位
			for (int i = source.length; i < 32; i++) {
				headBuffer.put(EMPTY);
			}
			headBuffer.put(dest); // 目标 ID
			// 补充到32位
			for (int i = dest.length; i < 32; i++) {
				headBuffer.put(EMPTY);
			}
			headBuffer.put(data);
			headBuffer.flip();
			channel.configureBlocking(false);
			channel.write(headBuffer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ((channel != null) && (channel.isConnected())) {
				try {
					channel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 发送并返回SocketChannel，最后需要调用者关闭SocketChanel。在需要返回的时候用到
	 * 
	 * @return
	 */
	public SocketChannel sendWithResponse() {
		SocketChannel channel = null;
		try {
			byte[] data = content != null ? this.content.getBytes("utf8")
					: new byte[0];
			byte[] source = sourceId != null ? sourceId.getBytes("utf8")
					: new byte[0];
			byte[] dest = destId != null ? destId.getBytes("utf8")
					: new byte[0];

			InetSocketAddress socketAddress = new InetSocketAddress(ip, port);
			channel = SocketChannel.open(socketAddress);

			ByteBuffer headBuffer = ByteBuffer.allocate(80 + data.length);
			headBuffer.order(ByteOrder.LITTLE_ENDIAN);
			headBuffer.putInt(version); // 版本号
			headBuffer.putInt(data.length); // 指令长度
			headBuffer.putInt(number); // 指令编号
			headBuffer.putInt(seq); // 指令序号
			headBuffer.put(source); // 源ID
			// 补充到32位
			for (int i = source.length; i < 32; i++) {
				headBuffer.put(EMPTY);
			}
			headBuffer.put(dest); // 目标 ID
			// 补充到32位
			for (int i = dest.length; i < 32; i++) {
				headBuffer.put(EMPTY);
			}
			headBuffer.put(data);
			headBuffer.flip();
			channel.configureBlocking(false);
			channel.write(headBuffer);
		} catch (Exception e) {
			System.out.println("Connect to server - " + ip + ":" + port
					+ " error !");
			e.printStackTrace();
		}
		return channel;
	}

	/**
	 * 解析megaeyes协议的返回，并关闭通道
	 * 
	 * @param channel
	 *            通道
	 * @param sequence
	 *            请求协议seq
	 * @return
	 * @throws Exception
	 */
	public byte[] parseResponse(SocketChannel channel, int sequence)
			throws Exception {
		if (null == channel || !channel.isConnected()) {
			return null;
		}
		if (!channel.isBlocking()) {
			channel.configureBlocking(true);
		}
		ByteBuffer header = ByteBuffer.allocate(20);
		channel.read(header);
		byte[] array = header.array();
		// 数据长度
		// array[4]-array[7]四位是数据长度
		byte[] lengthContent = ByteUtil.subByteArray(array, 4, 4);
		int dataLength = ByteUtil.byteArrayToInt(lengthContent);

		// 指令号
		// array[8]-array[11]四位是指令号
		byte[] commandContent = ByteUtil.subByteArray(array, 8, 4);
		int command = ByteUtil.byteArrayToInt(commandContent);

		// 序号
		// array[12]-array[15]四位是序号
		byte[] seqContent = ByteUtil.subByteArray(array, 12, 4);
		int seq = ByteUtil.byteArrayToInt(seqContent);

		// 成功标志
		// array[16]-array[19]四位是成功标志
		byte[] successContent = ByteUtil.subByteArray(array, 16, 4);
		int success = ByteUtil.byteArrayToInt(successContent);

		if (seq != sequence) {
			return null;
		}

		System.out.println("dataLength = " + dataLength);

		byte[] rtn = new byte[dataLength];
		ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
		int temp = 0;
		int total = 0;
		while ((temp = channel.read(buffer)) > 0) {
			buffer.flip();
			buffer.get(rtn, total, temp);
			total += temp;
			buffer.clear();
			if (total >= dataLength) {
				break;
			}
		}
		if ((channel != null) && (channel.isConnected())) {
			try {
				channel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return rtn;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
}
