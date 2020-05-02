void call(){
  println "Task from libsimple"

  scm.each {k,v -> println "$k = $v"}
  println scm.dump()
  
  node() {
    scm.extensions <<[$class: 'RelativeTargetDirectory',  relativeTargetDir: 'checkout-directory']
    checkout scm 
    bat "dir"
  }
  
  binding.variables.each {k,v -> println "$k = $v"}
  
  echo "keyword version = ${version}"
  
  //echo "${VAR_1}"
  //echo "${VAR_2}"
  
}
