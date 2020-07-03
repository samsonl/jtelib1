
@Init
def init(context) {
  echo "Init"
}

@BeforeStep
def before(context) {
  echo "Before"
}

@AfterStep
def after(context) {
  echo "After"
}

@CleanUp
def clean(context) {
  echo "Clean"
}

@Notify
def notify(context) {
  echo "Notify"
}


