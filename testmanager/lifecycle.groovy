@Init
void call1(context){
  echo "lc:Init"
}
@BeforeStep
void call2(context){
  echo "lc:BeforeStep"
}
@AfterStep
void call3(context){
  echo "lc:AfterStep"
}
@CleanUp
void call4(context){
  echo "lc:CleanUp"
}
@Notify
void call5(context){
  echo "lc:Notify"
}
