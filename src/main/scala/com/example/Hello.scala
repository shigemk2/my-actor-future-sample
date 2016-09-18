package com.example

import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.Future
import scala.concurrent.duration._


object Hello {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("mySystem")
    implicit val timeout = Timeout(5 seconds)

    val props = Props[MyActor]
    val actor = system.actorOf(props, name = "myActor")

    val future1: Future[Any] = actor ? "hi"
    val future2: Future[Any] = actor ? "hello"
  }
}
