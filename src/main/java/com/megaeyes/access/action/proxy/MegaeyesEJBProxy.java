package com.megaeyes.access.action.proxy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SocketChannel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.output.XMLOutputter;

import com.megaeyes.access.action.datapackage.RequestDataPackage;
import com.megaeyes.access.action.datapackage.ResponseDataPackage;
import com.megaeyes.access.common.MessageType;
import com.megaeyes.access.exception.ExceptionHandler;


public abstract class MegaeyesEJBProxy {
	protected SocketChannel _channel;

	protected RequestDataPackage _requestPack = new RequestDataPackage();

	protected ResponseDataPackage _responsePack = new ResponseDataPackage();

	protected int _port;

	protected String _centerServerIP;

	protected transient Log logger = LogFactory.getLog(this.getClass());

	public MegaeyesEJBProxy(String centerServerIP, int port) {
		_centerServerIP = centerServerIP;
		_port = port;
	}

	/**
	 * 同C++接入服务器连接
	 */
	protected void connect() throws IOException {
		logger.info("Connecting to AccessServer[" + _centerServerIP + "]");

		InetSocketAddress socketAddress = new InetSocketAddress(
				_centerServerIP, _port);
		_channel = SocketChannel.open(socketAddress);

		logger.info("Create connection successful.");

	}

	/**
	 * 关闭同接入服务器之间的连接
	 */
	protected void release() {
		logger.info("start close conneciton");
		try {
			if (_channel != null) {
				_channel.close();
			}
		} catch (IOException ex) {
			ExceptionHandler.throwRuntimeException(ex);
		}

		logger.info("Close connection successful.");
	}

	/**
	 * 发送数据包
	 */
	protected void sendDataPackage() throws IOException {
		logger.info("Start send data package: " + this._requestPack);

		ByteBuffer headIntBuffer = ByteBuffer.allocate(16);
		if (this._requestPack.getMessageID() == 9300) {
			headIntBuffer.order(ByteOrder.BIG_ENDIAN);
		} else {
			headIntBuffer.order(ByteOrder.LITTLE_ENDIAN);
		}

		headIntBuffer.putInt(this._requestPack.getVersion());
		headIntBuffer.putInt(this._requestPack.getLength());
		headIntBuffer.putInt(this._requestPack.getMessageID());
		headIntBuffer.putInt(this._requestPack.getMessageNo());

		ByteBuffer buffer = ByteBuffer.allocate(this._requestPack.getLength() + 64);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.put(this._requestPack.getSourceID());
		buffer.put(this._requestPack.getDestinationID());
		if (this._requestPack.getLength() > 0) {
			buffer.put(this._requestPack.getBody());
		}

		headIntBuffer.flip();
		_channel.write(headIntBuffer);
		headIntBuffer.clear();

		buffer.flip();
		_channel.write(buffer);
		buffer.clear();

		logger.info("Send data package successful.");
	}

	/**
	 * 接收数据包
	 */
	protected void receiveDataPackage() throws IOException {
		logger.info("Start receive data package.");
		// 读报文头
		ByteBuffer headBuffer = ByteBuffer.allocate(20);
		if (this._requestPack.getMessageID() == 9300) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			headBuffer.order(ByteOrder.BIG_ENDIAN);
		} else {
			headBuffer.order(ByteOrder.LITTLE_ENDIAN);
		}
		_channel.read(headBuffer);
		headBuffer.flip();

		this._responsePack.setVersion(headBuffer.getInt());
		int len = headBuffer.getInt();
		this._responsePack.setLength(len);
		this._responsePack.setMessageID(headBuffer.getInt());
		this._responsePack.setMessageNo(headBuffer.getInt());

		this._responsePack.setNSuccess(headBuffer.getInt());
		headBuffer.clear();

		// 读报文数据
		if (len > 0) {
			ByteBuffer contentBuffer = ByteBuffer.allocate(len);
			contentBuffer.order(ByteOrder.LITTLE_ENDIAN);
			_channel.read(contentBuffer);
			contentBuffer.flip();
			this._responsePack.setBody(contentBuffer.array());
			contentBuffer.clear();
		}

		logger.info("Receive data package successful: " + this._responsePack);
	}

	// 生成发送包
	protected void generateRequestDataPackage(int messageId, byte[] destId,	Document doc) throws IOException {
		ByteArrayOutputStream outXMLStream = new ByteArrayOutputStream();
		byte[] body = null;

		if (doc != null) {
			//Format format = Format.getPrettyFormat();
			//format.setEncoding("GBK");
			XMLOutputter out = new XMLOutputter("  ", true, "UTF-8");
			out.output(doc, outXMLStream);
			body = outXMLStream.toByteArray();
		}

		_requestPack.setVersion(MessageType.PROTOCOL_VERSION);

		if (body != null) {
			_requestPack.setLength(body.length);
		}
		_requestPack.setMessageID(messageId);
		_requestPack.setMessageNo(0);

		byte[] sourceID = new byte[32];
		byte[] j2eeSourceID = MessageType.J2EE_ID.getBytes();
		System.arraycopy(j2eeSourceID, 0, sourceID, 0, j2eeSourceID.length);
		_requestPack.setSourceID(sourceID);

		byte[] destinationID = new byte[32];

		if (destId == null) {
			destId = MessageType.CENTER_ID.getBytes();
		}
		System.arraycopy(destId, 0, destinationID, 0, destId.length);

		_requestPack.setDestinationID(destinationID);
		_requestPack.setBody(body);

	}

	// 生成发送包
	protected void generateRequestDataPackageByCharSet(int messageId, byte[] destId, Document doc, String charSet) throws IOException {

		ByteArrayOutputStream outXMLStream = new ByteArrayOutputStream();
		byte[] body = null;

		if (doc != null) {
			XMLOutputter out = new XMLOutputter("  ", true, "UTF-8");
			out.output(doc, outXMLStream);
			//format.setEncoding(charSet);
			//XMLOutputter xmlOut = new XMLOutputter(format);
			//xmlOut.output(doc, outXMLStream);
			body = outXMLStream.toByteArray();
		}

		_requestPack.setVersion(MessageType.PROTOCOL_VERSION);

		if (body != null) {
			_requestPack.setLength(body.length);
		}
		_requestPack.setMessageID(messageId);
		_requestPack.setMessageNo(0);

		byte[] sourceID = new byte[32];
		byte[] j2eeSourceID = MessageType.J2EE_ID.getBytes();
		System.arraycopy(j2eeSourceID, 0, sourceID, 0, j2eeSourceID.length);
		_requestPack.setSourceID(sourceID);

		byte[] destinationID = new byte[32];

		if (destId == null) {
			destId = MessageType.CENTER_ID.getBytes();
		}
		System.arraycopy(destId, 0, destinationID, 0, destId.length);

		_requestPack.setDestinationID(destinationID);
		_requestPack.setBody(body);

	}

}