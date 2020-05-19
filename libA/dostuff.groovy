package util

public class Helper {
  public helpme() {
    println "HELPME"
  }
}
def getHelper() {
  return new util.Helper()
}

def call() {
  echo "libA dostuff"
  echo "Task.localC = ${task.getLocalC()}"
  
  def hel = new util.Helper()
  hel.helpme();
  println ">> CLASS:${hel.getClass()}"
  
  
}
