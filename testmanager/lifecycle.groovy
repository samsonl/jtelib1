@Init
void call(context){
  echo "lc:Init"
}
@BeforeStep
void call(context){
  echo "lc:BeforeStep"
}
@AfterStep
void call(context){
  echo "lc:AfterStep"
}
@CleanUp
void call(context){
  echo "lc:CleanUp"
}
@Notify
void call(context){
  echo "lc:Notify"
}
