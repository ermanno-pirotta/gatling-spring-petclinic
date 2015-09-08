package org.piro84.performance.petclinic.request

import scala.util.Random
/**
 * Contains custom utils for performing requests to the petclinic.
 */
object RequestUtils {
   val random = (list: Seq[String]) => {
    list(Random.nextInt(list.size))
  }
}