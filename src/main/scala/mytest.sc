println("ok")
val auto = new Automator()
println(auto.lawnGrid)
auto.runSequence(List("5 5", "1 2 N", "GAAGGGAGGGAA"))
