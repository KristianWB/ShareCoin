package com.example.sharecoin;

public class Search {

    public String getThisusername()
    {
        return thisusername;
    }

    public void setThisusername(String thisusername)
    {
        this.thisusername = thisusername;
    }

    public String getThisPassword()
    {
        return thisPassword;
    }

    public void setThisPassword(String thisPassword)
    {
        this.thisPassword = thisPassword;
    }

    public String getBlockChainContains() {
        return blockChainContains;
    }

    public void setBlockChainContains(String blockChainContains)
    {
        this.blockChainContains = blockChainContains;
    }

    private String thisusername;
    private String thisPassword;

    private String blockChainContains;

    public boolean verifyUsernameAndPassword(String username,String password)
    {
        if(username==thisusername&&password==thisPassword)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean verifyBlockchain(String contains)
    {
        if(blockChainContains==contains)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
