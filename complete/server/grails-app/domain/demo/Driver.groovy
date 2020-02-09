package demo

import grails.rest.Resource

@Resource(uri = '/driver')
class Driver {

    String name

	Licence licence
	Bid bid
	
}
