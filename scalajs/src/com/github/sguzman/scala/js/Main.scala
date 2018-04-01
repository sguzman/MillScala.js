package com.github.sguzman.scala.js

import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object Main {
  @dom def render: Binding[Div] = {
    <div>
      <h1>Hello</h1>
    </div>
  }

  def main(args: Array[String]): Unit = {
    println("hello")
    com.thoughtworks.binding.dom.render(org.scalajs.dom.document, render)
  }
}