package com.megaeyes.access.action.data;

/**
 * 
 * @Title: UserAuthorizationRequestData.java 
 * @Package com.megaeyes.access.action.data 
 * @Description: 用户操作权限验证
 * @author zhuanqi@megaeyes.com   
 * @date 2012-11-29 上午06:37:36 
 * @version V1.0
 */
public class UserAuthorizationRequestData  
{

    private String m_userSessionId;

    private String m_resourceType;

    private String m_operationKey;

    private String m_resourceId;

    private String m_resourceNaming;

    private boolean m_isPass = false;
    
    private String m_dispatchServerId;
    
    public String getDispatchServerId(){
    	return m_dispatchServerId;
    }
    
    public void setDispatchServerId(String dispatchServerId){
    	this.m_dispatchServerId = dispatchServerId;
    }


    public String getUserSessionId()
    {

        return m_userSessionId;
    }

    public void setUserSessionId(String userSessionId)
    {

        this.m_userSessionId = userSessionId;
    }
    
    public String getResourceNaming()
    {

        return m_resourceNaming;
    }

    public void setResourceNaming(String userSessionNaming)
    {

        this.m_resourceNaming = userSessionNaming;
    }

    public String getResourceType()
    {

        return m_resourceType;
    }

    public void setResourceType(String resourceType)
    {

        this.m_resourceType = resourceType;
    }

    public String getOperationKey()
    {

        return m_operationKey;
    }

    public void setOperationKey(String operationKey)
    {

        this.m_operationKey = operationKey;
    }

    public String getResourceId()
    {

        return m_resourceId;
    }

    public void setResourceId(String resourceId)
    {

        this.m_resourceId = resourceId;
    }

    public boolean getIsPass()
    {

        return m_isPass;
    }

    public void setIsPass(boolean isPass)
    {

        this.m_isPass = isPass;
    }

    /**
     * struction
     */
    public UserAuthorizationRequestData()
    {

        super();
        // TODO �Զ���ɹ��캯����
    }

    public boolean isRollbackOnly()
    {

        System.out.println("isRollbackOnly()");
        return false;
    }

    public void setRollbackOnly()
    {

        System.out.println("setRollbackOnly()");
    }

    public void cleanUnprofitableData()
    {

        //System.out.println("cleanUnprofitableData()");
    }

}