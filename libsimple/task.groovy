void call(){
  println "Task from libsimple"

  println scm.dump()
  
  echo "ON NODE"
  node() {
    scm.extensions << [$class: 'RelativeTargetDirectory',  relativeTargetDir: 'cd1']
    
    println scm.extensions
    println scm.extensions.getClass()
    //scm.relativeTargetDir="cd2"
     println scm.dump()
    checkout scm 
    bat "dir"
  }
  
  binding.variables.each {k,v -> println "$k = $v"}
  
  echo "keyword version = ${version}"
  
  //echo "${VAR_1}"
  //echo "${VAR_2}"
  
}
