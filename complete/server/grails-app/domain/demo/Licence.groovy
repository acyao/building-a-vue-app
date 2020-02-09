package demo

import grails.rest.Resource

@Resource(uri = '/licence')
class Licence {

    String licence_class
	String licence_no
	
}
