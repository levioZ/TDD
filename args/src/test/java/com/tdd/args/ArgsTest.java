package com.tdd.args;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ArgsTest
{
    @Test
    public void should_return_true_when_argument_contains_l_flag()
    {
        String[] arguments = new String[]{"-l"};

        Args args = Args.parse(arguments);
        boolean result = args.hasFlag("l");
        assertThat(result).isTrue();
    }

    @Test
    public void should_return_true_when_argument_contains_p_flag()
    {
        String[] arguments = new String[]{"-p","8000"};

        Args args = Args.parse(arguments);
        boolean result = args.hasFlag("p");
        assertThat(result).isTrue();
    }

    @Test
    public void should_return_value_when_value_is_not_null()
    {
        String[] arguments = new String[]{"-p","8000"};

        Args args = Args.parse(arguments);
        String value = args.getvalue("p");
        assertThat(value).isEqualTo("8000");

    }

    @Test
    public void should_return_null_when_value_is_null()
    {
        String[] arguments = new String[]{"-p"};

        Args args = Args.parse(arguments);
        String value = args.getvalue("p");
        assertThat(value).isNullOrEmpty();

    }
}
