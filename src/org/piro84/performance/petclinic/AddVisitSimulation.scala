package org.piro84.performance.petclinic

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AddVisitSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost:9966")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png"""), WhiteList())



    val uri1 = "http://localhost:9966/petclinic"

	val scn = scenario("AddVisitSimulation")
		.exec(http("request_0")
			.get("/petclinic/owners/find.html"))
		.pause(16)
		.exec(http("request_1")
			.get("/petclinic/owners.html?lastName="))
		.pause(2)
		.exec(http("request_2")
			.get("/petclinic/owners/10.html"))
		.pause(12)
		.exec(http("request_3")
			.get("/petclinic/owners/10/pets/13/visits/new"))
		.pause(11)
		.exec(http("request_4")
			.post("/petclinic/owners/10/pets/13/visits/new")
			.formParam("date", "2015/09/09")
			.formParam("description", "test visit")
			.formParam("petId", "13"))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}