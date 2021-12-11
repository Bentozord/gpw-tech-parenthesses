package com.bentozord.validator

import spock.lang.Specification

class ParenthesesValidatorSpec extends Specification {

    def 'should validate parentheses properly'() {
        when:
            def validity = ParenthesesValidator.validateParentheses(input)
        then:
            validity == result
        where:
            input       || result
            "(){}[]"    ||  true
            "([{}])"    ||  true
            "(}"        ||  false
            "[(])"      ||  false
            "[({})](]"  ||  false
            "(({}]()"   ||  false
            "))"        ||  false

    }
}
