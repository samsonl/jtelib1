void call(){
  println "Task from libsimple"
  
  node() {
    scm.extensions = [[$class: 'RelativeTargetDirectory',  relativeTargetDir: 'checkout-directory']]
    checkout scm 
    bat "dir"
  }
  
  binding.variables.each {k,v -> println "$k = $v"}
  
  echo "keyword version = ${version}"
  
  //echo "${VAR_1}"
  //echo "${VAR_2}"
  
}
