package com.megaeyes.access.action.proxy;

import java.io.IOException;

import com.megaeyes.access.exception.DeviceConfigFailException;
import com.megaeyes.access.exception.DeviceQueryFailException;

public abstract class DeviceProxy extends MegaeyesEJBProxy {
	public DeviceProxy(String centerServerIP, int port) {
		super(centerServerIP, port);
	}

	public Object configureDevice(Object requestObj) throws DeviceConfigFailException {
		Object responseObj = null;

		try {
			// 建立连接
			this.connect();

			// 将传送的对象转换成发送数据包
			this.requestConfiguredToPackage(requestObj);

			// 发送数据包
			this.sendDataPackage();

			// 接收数据包
			this.receiveDataPackage();

			if (this._responsePack.getNSuccess() != 0) {
				throw new DeviceConfigFailException("AccessServer error! Error code: "	+ String.valueOf(_responsePack.getNSuccess()));
			}
		} catch (IOException ioe) {
			throw new DeviceConfigFailException(ioe.getMessage(), ioe);
		}
		finally {
			// 关闭连接
			release();
		}

		return responseObj;
	}

	public Object getCaptionParam(Object requestObj) throws DeviceQueryFailException {
		Object responseObj = null;

		try {
			// 建立连接
			this.connect();

			// 将传送的对象转换成发送数据包
			this.requestCaptionToPackage(requestObj);

			// 发送数据包
			this.sendDataPackage();

			// 接收数据包
			this.receiveDataPackage();

			if (this._responsePack.getNSuccess() == 0) {
				responseObj = this.responseCaptionToObject(requestObj);
			} else {
				throw new DeviceQueryFailException("AccessServer error! Error code: " + String.valueOf(_responsePack.getNSuccess()));
			}
		} catch (IOException ioe) {
			throw new DeviceQueryFailException(ioe.getMessage(), ioe);
		}

		finally {
			// 关闭连接
			release();
		}

		return responseObj;
	}

	public Object queryDevice(Object requestObj) throws DeviceQueryFailException {
		Object responseObj = null;

		try {
			// 建立连接
			this.connect();

			// 将传送的对象转换成发送数据包
			this.requestQueriedToPackage(requestObj);

			// 发送数据包
			this.sendDataPackage();

			// 接收数据包
			this.receiveDataPackage();

			if (this._responsePack.getNSuccess() == 0) {
				// 将接收到的数据包中的XML转换成值对象
				responseObj = this.responseQueriedToObject();
			} else {
				throw new DeviceQueryFailException("AccessServer error! Error code: " + String.valueOf(_responsePack.getNSuccess()));
			}
		} catch (IOException ioe) {
			throw new DeviceQueryFailException(ioe.getMessage(), ioe);
		}

		finally {
			// 关闭连接
			release();
		}

		return responseObj;
	}

	protected abstract void requestConfiguredToPackage(Object inObject);

	protected abstract void requestQueriedToPackage(Object inObject);

	protected abstract Object responseQueriedToObject();

	protected abstract Object responseCaptionToObject(Object outObject);

	protected abstract void requestCaptionToPackage(Object requestObj);
}