void call(){
  println "Task from libsimple"
  
 cmd "dir"
  
 binding.variables.each {k,v -> println "$k = $v"}
  
  echo "keyword version = ${version}"
  
  //echo "${VAR_1}"
  //echo "${VAR_2}"
  
}
