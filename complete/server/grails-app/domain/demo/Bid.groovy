package demo

import grails.rest.Resource

@Resource(uri = '/bid')
class Bid {
    String date
	String amount
	 
}
