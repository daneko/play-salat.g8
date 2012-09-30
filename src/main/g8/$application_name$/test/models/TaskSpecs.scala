package models

import play.api.test._
import play.api.test.Helpers._
import org.specs2.mutable._
import org.specs2.specification.Scope
import org.specs2.runner.JUnitRunner
import org.junit.runner.RunWith

import com.mongodb.casbah.MongoConnection

@RunWith(classOf[JUnitRunner])
class TaskSpecs2 extends Specification {
  sequential

  "using task model" should {
    "get all task" in context {
      running(context.fakeApp) {
        Task.all.size must_== 0

        Task.create("hoge")
        Task.create("fuga")

        Task.all.size must_== 2
      }
    }
  }

  object context extends BeforeAfter {

    lazy val dummy_db_name = "test_app_db"

    lazy val fakeApp = FakeApplication(additionalConfiguration = Map("mongodb.default.db" -> dummy_db_name))

    def before = {
      implicit val mongoDB = MongoConnection()(dummy_db_name)
      mongoDB.dropDatabase()
    }

    def after = ()
  }

}