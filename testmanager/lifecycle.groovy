@Init
void call1(context){
  //echo "lc:Init ${context}"
}
@BeforeStep
void call2(context){
  //echo "lc:BeforeStep ${context}"
}
@AfterStep
void call3(context){
  //echo "lc:AfterStep ${context}"
}
@CleanUp
void call4(context){
  //echo "lc:CleanUp ${context}"
}

@groovy.transform.Field notify_called = false
@Notify
void call5(context){
  echo "lc:Notify ${context} called : ${notify_called}"
  notify_called = true
}
