package org.piro84.performance.petclinic.config

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.session._

/**
 * Specifies configuration testing for tuning the performance tests.
 */
object Config {
    /**
   * Server name. Default is localhost
   */
  val SERVER = System.getProperty("server", "localhost")

  /**
   * http port. default is 9966
   */
  val HTTP_PORT = Integer.getInteger("httpPort", 9966).toInt

  /**
   * Default think time in seconds.
   */
  val THINK_TIME_DEFAULT_SECONDS = Integer.getInteger("thinkTime", 3).toInt

  /**
   * user rate
   */
  val USER_PER_SEC = System.getProperty("usersPerSecond", "6").toDouble

  
   /**
   * Duration
   */
  val DURATION = Integer.getInteger("duration", 60).toInt
  
  
  val REPEAT_COUNT = Integer.getInteger("repeatCount", 2).toInt
  /**
   * http protocol;
   */
  val HTTP_PROTOCOL = http
  .acceptHeader("text/html, */*; q=0.01")
    .baseURL(serverHttpUrl())
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-us,en;q=0.8,fr;q=0.5,fr-fr;q=0.3")
    .connection("keep-alive")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:30.0) Gecko/20100101 Firefox/30.0")

  def serverHttpUrl(): String = {
    "http://" + SERVER + ":" + HTTP_PORT
  }

}