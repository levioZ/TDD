package com.tdd.args;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.HashMap;
import java.util.Map;

public class Args
{

    private final Map<String, String> flagToValueMap;

    public Args(Map<String, String> flagToValueMap)
    {
       this.flagToValueMap = flagToValueMap;
    }

    public static Args parse(String[] arguments)
    {
        Map<String, String> flagToValueMap = new HashMap<String, String>();

        for (int index = 0; index < arguments.length; index++)
        {
             if(isFlag(arguments[index]))
             {
                 String flag = arguments[index].substring(1);
                 String value = hasValue(arguments, index+1)? arguments[index+1] : null;
                 flagToValueMap.put(flag, value);
             }

        }
        
        return new Args(flagToValueMap);

    }

    private static boolean hasValue(String[] arguments, int valueIndex)
    {
       return !stackOverFlow(arguments, valueIndex) && !isFlag(arguments[valueIndex]);
    }

    private static boolean stackOverFlow(String[] arguments, int valueIndex) {
        return arguments.length - 1 < valueIndex;
    }

    private static boolean isFlag(String argument)
    {
        return  argument.startsWith("-") && argument.length() == 2;
    }

    public boolean hasFlag(String flag)
    {
        return this.flagToValueMap.containsKey(flag);
    }

    public String getvalue(String flag)
    {
        return this.flagToValueMap.get(flag);
    }
}
