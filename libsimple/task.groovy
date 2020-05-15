void call(){
  println "Task from libsimple"

   global {
     A = "aval"
     B = "B" ?: "default if not set"
     //C = { p -> echo ">>> ${p}" }
  }
  echo "global.A = ${global.A}"
  global.A = "AAAAA'
  echo "global.A = ${global.A}"
  global = [A:"BBBBB"]
  echo "global.A = ${global.A}"
  
  //println Stages2.STAGE_TWO
  //println Stages2.STAGE_ONE
  
   properties([
        parameters([string(defaultValue: 'aaaaa', description: '', name: 'a', trim: false)]),
   ])
  
  println scm.dump()
  
  echo "ON NODE"
  node() {
    /*
    //scm.extensions << [$class: 'RelativeTargetDirectory',  relativeTargetDir: 'cd1']
    extensions = [[$class: 'RelativeTargetDirectory',  relativeTargetDir: 'cd1']]
    
    def dl = new hudson.util.DescribableList(hudson.model.Saveable.NOOP,extensions);
    println "DL ${dl.dump()}"
    scm.extensions.addAll(dl)
    println "After add"
    println "SCM.extensions : ${scm.extensions}"
    
    println scm.extensions.getClass()
    println scm.extensions.dump()
    echo "----"
    //scm.relativeTargetDir="cd2"
    println scm.dump()
    
    dl = null
    */
    
    cleanWs()
    
    //def exts = []
    //scm.extensions.each { i -> exts << i }
    //exts << [$class: 'RelativeTargetDirectory',  relativeTargetDir: 'cd1']
    //println "EXTS ${exts.dump()}"
    //exts = null
    
    //checkout scm  
    checkout( [ $class: 'GitSCM',
      branches: scm.branches,
      doGenerateSubmoduleConfigurations: scm.doGenerateSubmoduleConfigurations,
      //extensions: [scm.extensions[0],scm.extensions[1],[$class: 'RelativeTargetDirectory',  relativeTargetDir: 'cd1']],
      extensions: scm.extensions.collect() + [$class: 'RelativeTargetDirectory',  relativeTargetDir: 'cd1'],
      userRemoteConfigs: scm.userRemoteConfigs
    ])
    
    bat "dir"
  }
  
  binding.variables.each {k,v -> println "$k = $v"}
  
  echo "keyword version = ${version}"
  
  //echo "${VAR_1}"
  echo "${VAR_2}"
  
  //globl.C("Stuff")
}
