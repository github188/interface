package com.megaeyes.persistence.ibatis.model;

import java.io.Serializable;

public class EpGatherServer implements Serializable {
    /**
     * EP_GATHER_SERVER.ID
     * null
     */
    private String id;

    /**
     * EP_GATHER_SERVER.ORGAN_ID
     * null
     */
    private String organId;

    /**
     * EP_GATHER_SERVER.IP
     * null
     */
    private String ip;

    /**
     * EP_GATHER_SERVER.NAME
     * null
     */
    private String name;

    /**
     * EP_GATHER_SERVER.NOTE
     * null
     */
    private String note;

    /**
     * EP_GATHER_SERVER.HEART_CYCLE
     * null
     */
    private Long heartCycle;

    /**
     * EP_GATHER_SERVER.EVENT_SERVER_ID
     * null
     */
    private String eventServerId;

    /**
     * EP_GATHER_SERVER.EVENT_PORT
     * null
     */
    private String eventPort;

    /**
     * EP_GATHER_SERVER.CLIENT_PORT
     * null
     */
    private String clientPort;

    /**
     * EP_GATHER_SERVER.CONSOLE_LISTENER_IP
     * null
     */
    private String consoleListenerIp;

    /**
     * EP_GATHER_SERVER.CONSOLE_LISTENER_PORT
     * null
     */
    private String consoleListenerPort;

    /**
     * EP_GATHER_SERVER.CONSOLE_PASSWORD
     * null
     */
    private String consolePassword;

    /**
     * EP_GATHER_SERVER.CLIENT_IP
     * null
     */
    private String clientIp;

    /**
     * EP_GATHER_SERVER.EVENT_IP
     * null
     */
    private String eventIp;

    /**
     * EP_GATHER_SERVER.DEVICE_NUMBER
     * null
     */
    private String deviceNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getHeartCycle() {
        return heartCycle;
    }

    public void setHeartCycle(Long heartCycle) {
        this.heartCycle = heartCycle;
    }

    public String getEventServerId() {
        return eventServerId;
    }

    public void setEventServerId(String eventServerId) {
        this.eventServerId = eventServerId;
    }

    public String getEventPort() {
        return eventPort;
    }

    public void setEventPort(String eventPort) {
        this.eventPort = eventPort;
    }

    public String getClientPort() {
        return clientPort;
    }

    public void setClientPort(String clientPort) {
        this.clientPort = clientPort;
    }

    public String getConsoleListenerIp() {
        return consoleListenerIp;
    }

    public void setConsoleListenerIp(String consoleListenerIp) {
        this.consoleListenerIp = consoleListenerIp;
    }

    public String getConsoleListenerPort() {
        return consoleListenerPort;
    }

    public void setConsoleListenerPort(String consoleListenerPort) {
        this.consoleListenerPort = consoleListenerPort;
    }

    public String getConsolePassword() {
        return consolePassword;
    }

    public void setConsolePassword(String consolePassword) {
        this.consolePassword = consolePassword;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getEventIp() {
        return eventIp;
    }

    public void setEventIp(String eventIp) {
        this.eventIp = eventIp;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }
}