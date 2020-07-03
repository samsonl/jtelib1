
@Init
def init(context) {
  echo "Init ${context}"
}

@BeforeStep
def before(context) {
  echo "Before ${context}"
}

@AfterStep
def after(context) {
  echo "After ${context}"
}

@CleanUp
def clean(context) {
  echo "Clean ${context}"
}

@Notify
def notify(context) {
  echo "Notify ${context}"
}


