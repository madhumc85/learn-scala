package br.com.mystudies.scala

object UnderstandingTraits extends App {

}


trait Friend{
  val name: String
  def listen = println(s"Your friend $name is listening")
}


class Human(val name: String ) extends Friend
class Animal

class Man(override val name: String ) extends Human(name)
class Woman(override val name: String ) extends Human(name)


class Dog(val name: String) extends Animal with Friend{
  // optionally override method here.
  override def listen = println(s"$name's lisgening quietly")
}


