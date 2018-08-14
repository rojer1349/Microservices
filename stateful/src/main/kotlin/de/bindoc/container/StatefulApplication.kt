package de.bindoc.container

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StatefulApplication

fun main(args: Array<String>) {
  runApplication<StatefulApplication>(*args)
}
