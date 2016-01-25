package com.megaeyes.access.action.proxy;

import java.io.IOException;

import com.megaeyes.access.exception.DeviceConfigFailException;

public abstract class AlarmConfigProxy extends MegaeyesEJBProxy {
	public AlarmConfigProxy(String centerServerIP, int port) {
		super(centerServerIP, port);
	}

	public Object getPlan(Object requestObj) throws DeviceConfigFailException {

		try {
			// 建立连接
			this.connect();

			// 将传送的对象转换成发送数据包
			this.requestPlanToPackage(requestObj);

			// 发送数据包
			this.sendDataPackage();

			// 接收数据包
			this.receiveDataPackage();

			if (this._responsePack.getNSuccess() == 0) {
				// 将接收到的数据包中的XML转换成值对象
				requestObj = this.responsePlanToObject(requestObj);
			}

		} catch (IOException ioe) {
			throw new DeviceConfigFailException("create connection failed", ioe);
		}

		finally {
			// 关闭连接
			release();
		}

		return requestObj;
	}

	public Object getAlarmConfig(Object requestObj)
			throws DeviceConfigFailException {

		try {
			// 建立连接
			this.connect();

			// 将传送的对象转换成发送数据包
			this.requestAlarmConfigToPackage(requestObj);

			// 发送数据包
			this.sendDataPackage();

			// 接收数据包
			this.receiveDataPackage();

			if (this._responsePack.getNSuccess() == 0) {
				// 将接收到的数据包中的XML转换成值对象
				requestObj = this.responseAlarmConfigToObject(requestObj);
			}

		} catch (IOException ioe) {
			throw new DeviceConfigFailException("create connection failed", ioe);
		}

		finally {
			// 关闭连接
			release();
		}

		return requestObj;
	}

	public Object getTimingShooting(Object requestObj)
			throws DeviceConfigFailException {

		try {
			// 建立连接
			this.connect();

			// 将传送的对象转换成发送数据包
			this.requestTimingShootingToPackage(requestObj);

			// 发送数据包
			this.sendDataPackage();

			// 接收数据包
			this.receiveDataPackage();

			if (this._responsePack.getNSuccess() == 0) {
				// 将接收到的数据包中的XML转换成值对象
				requestObj = this.responseTimingShootingToObject(requestObj);
			}

		} catch (IOException ioe) {
			throw new DeviceConfigFailException("create connection failed", ioe);
		}

		finally {
			// 关闭连接
			release();
		}

		return requestObj;
	}

	public Object getAlarm(Object requestObj) throws DeviceConfigFailException {

		try {
			// 建立连接
			this.connect();

			// 将传送的对象转换成发送数据包
			this.requestAlarmToPackage(requestObj);

			// 发送数据包
			this.sendDataPackage();

			// 接收数据包
			this.receiveDataPackage();

			if (this._responsePack.getNSuccess() == 0) {
				// 将接收到的数据包中的XML转换成值对象
				requestObj = this.responseAlarmToObject(requestObj);
			}

		} catch (IOException ioe) {
			throw new DeviceConfigFailException("create connection failed", ioe);
		}

		finally {
			// 关闭连接
			release();
		}

		return requestObj;
	}

	public Object getDetect(Object requestObj) throws DeviceConfigFailException {

		try {
			// 建立连接
			this.connect();

			// 将传送的对象转换成发送数据包
			this.requestDetectToPackage(requestObj);

			// 发送数据包
			this.sendDataPackage();

			// 接收数据包
			this.receiveDataPackage();

			if (this._responsePack.getNSuccess() == 0) {
				// 将接收到的数据包中的XML转换成值对象
				requestObj = this.responseDetectToObject(requestObj);
			}

		} catch (IOException ioe) {
			throw new DeviceConfigFailException("create connection failed", ioe);
		}

		finally {
			// 关闭连接
			release();
		}

		return requestObj;
	}

	public void updatePlan(Object requestObj) throws DeviceConfigFailException {

		try {
			// 建立连接
			this.connect();

			// 将传送的对象转换成发送数据包
			this.updatePlanToPackage(requestObj);

			// 发送数据包
			this.sendDataPackage();

			// 接收数据包
			this.receiveDataPackage();

			if (this._responsePack.getNSuccess() == 0) {

			}

		} catch (IOException ioe) {
			throw new DeviceConfigFailException("create connection failed", ioe);
		}

		finally {
			// 关闭连接
			release();
		}

	}

	public void updateAlarmConfig(Object requestObj)
			throws DeviceConfigFailException {

		try {
			// 建立连接
			this.connect();

			// 将传送的对象转换成发送数据包
			this.updateAlarmConfigToPackage(requestObj);

			// 发送数据包
			this.sendDataPackage();

			// 接收数据包
			this.receiveDataPackage();

			if (this._responsePack.getNSuccess() != 0) {
				throw new DeviceConfigFailException("device connection failed");
			}

		} catch (IOException ioe) {
			throw new DeviceConfigFailException("create connection failed", ioe);
		}

		finally {
			// 关闭连接
			release();
		}

	}

	public void updateTimingShooting(Object requestObj)
			throws DeviceConfigFailException {

		try {
			// 建立连接
			this.connect();

			// 将传送的对象转换成发送数据包
			this.updateTimingShootingToPackage(requestObj);

			// 发送数据包
			this.sendDataPackage();

			// 接收数据包
			this.receiveDataPackage();

			if (this._responsePack.getNSuccess() == 0) {

			}

		} catch (IOException ioe) {
			throw new DeviceConfigFailException("create connection failed", ioe);
		}

		finally {
			// 关闭连接
			release();
		}

	}

	public void updateAlarm(Object requestObj) throws DeviceConfigFailException {

		try {
			// 建立连接
			this.connect();

			// 将传送的对象转换成发送数据包
			this.updateAlarmToPackage(requestObj);

			// 发送数据包
			this.sendDataPackage();

			// 接收数据包
			this.receiveDataPackage();

			if (this._responsePack.getNSuccess() == 0) {

			}

		} catch (IOException ioe) {
			throw new DeviceConfigFailException("create connection failed", ioe);
		}

		finally {
			// 关闭连接
			release();
		}

	}

	public void updateDetect(Object requestObj)
			throws DeviceConfigFailException {

		try {
			// 建立连接
			this.connect();

			// 将传送的对象转换成发送数据包
			this.updateDetectToPackage(requestObj);

			// 发送数据包
			this.sendDataPackage();

			// 接收数据包
			this.receiveDataPackage();

			if (this._responsePack.getNSuccess() == 0) {
			}

		} catch (IOException ioe) {
			throw new DeviceConfigFailException("create connection failed", ioe);
		}

		finally {
			// 关闭连接
			release();
		}

	}

	protected abstract void requestPlanToPackage(Object inObject);

	protected abstract void requestAlarmConfigToPackage(Object inObject);

	protected abstract void requestTimingShootingToPackage(Object inObject);

	protected abstract void requestAlarmToPackage(Object inObject);

	protected abstract void requestDetectToPackage(Object inObject);

	protected abstract void updatePlanToPackage(Object inObject);

	protected abstract void updateAlarmConfigToPackage(Object inObject);

	protected abstract void updateTimingShootingToPackage(Object inObject);

	protected abstract void updateAlarmToPackage(Object inObject);

	protected abstract void updateDetectToPackage(Object inObject);

	protected abstract Object responsePlanToObject(Object requestObject);

	protected abstract Object responseAlarmConfigToObject(Object requestObject);

	protected abstract Object responseTimingShootingToObject(Object requestObject);

	protected abstract Object responseAlarmToObject(Object requestObject);

	protected abstract Object responseDetectToObject(Object requestObject);
}