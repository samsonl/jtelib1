import groovy.transform.Field
import org.boozallen.plugins.jte.console.TemplateLogger

@Field
step_name = "task.groovy"

localA = "localA"
def localB = "localB"
@Field
localC = "localC"
println "OK"


def getLocalC() { return this.@localC }

 
void call(){
 echo "1.config.A = ${config.A}"
 
 call([A:"override A"],[A:"config A override"])
 //call(global,config)
}
void call(global, config){
  println "Task from libsimple"
  echo "global.A Values = ${global.A}"
  echo "global.B Values = ${global.B}"
  echo "config.A = ${config.A}"
 
   
println "Exception Test - Start"
try {
   error "FAIL ME SHELL"
} catch (Exception e ) {
   println "Err:${e.getMessage()}"
   //throw new Exception("ALL DONE AND DID NOT WORK")
}
println "Exception Test - Done"
 
 this.getBinding().getVariables().each { n,v ->
  println "var ${n}=${v}"
 }
 
 //def hel = new util.Helper()
 //help.helpme()
 def hel = dostuff.getHelper()
 hel.helpme()
 
 //echo "A=${localA}"
 //echo "B=${localB}"
 echo "C=${localC}"
 
  node() { 
    bat "dir > ipconfig.txt"
    archiveArtifacts artifacts:"ipconfig.txt"
  }
 TemplateLogger.print("OK GO\n1\n2", [initiallyHidden:true])
  node() {
    //def resp = bat(returnStdout:true,script:"@dir c:\\windows\\system32 /s")
   def resp = "AAAA" 
   TemplateLogger.print("Batch file output...\n"+resp, [initiallyHidden:true])
  } 

  //echo "Locals A=${this.localA} B=${localB} C=${localC}"
  echo "Locals C=${localC}"

  echo "A Values = ${global.A}"
  echo "B Values = ${global.B}"
  echo "C Values = ${global.C}"
  echo "D Values = ${global.D}"
  echo "Config A = ${config.A}"
  return
  
  set = "setA"
  echo "Set ${global.sets}"
  //global.sets.each { se ->
  //  echo "Set ${se} / ${se.getClass()}"
  //}
  //echo "Set A        = ${global.sets.setA}"
  //echo "Set A.name   = ${global.sets.setA.name}"
  //echo "Set B.name   = ${global.sets.setB.name}"
  echo "Set [set]    = ${global.sets[set].name}"
  //echo "Set ['setA'] = ${global.sets['setA'].name}"
        
  echo "global.A = ${global.A}"

  printf ">>>${global.class}"
  printf ">>>${global.@config.getClass()}"
  def save_config = global.@config
  def field = global.class.getDeclaredField( "config" );field.setAccessible( true );field.set( global, [A:"AAAAAAVVVVVV"]);
  //field.set(global, new org.boozallen.plugins.jte.binding.injectors.ApplicationEnvironment("global", [A:"AAAAAAVVVVVV"]))
  
  //global.@config = [A:"AAAAA"]
  //global.A = "AAAAA"
  //echo "global.A = ${global.A}"
  //global = [A:"BBBBB"]
  echo "global.A = ${global.A}"
 field.set( global, save_config);
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
    
    bat "dir > ipconfig.txt"
    archiveArtifacts artifacts:"ipconfig.txt"
  }
  
  binding.variables.each {k,v -> println "$k = $v"}
  
  echo "keyword version = ${version}"
  
  //echo "${VAR_1}"
  echo "${VAR_2}"
  
  //globl.C("Stuff")
}
