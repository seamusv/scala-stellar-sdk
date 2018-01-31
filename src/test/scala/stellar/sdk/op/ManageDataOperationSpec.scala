package stellar.sdk.op

import org.scalacheck.Gen
import org.specs2.mutable.Specification
import stellar.sdk.DomainMatchers
import stellar.sdk.{ArbitraryInput, DomainMatchers}

class ManageDataOperationSpec extends Specification with ArbitraryInput with DomainMatchers {

  "a write data operation" should {
    "serde via xdr" >> prop { actual: WriteDataOperation =>
      Operation.fromXDR(actual.toXDR) must beSuccessfulTry.like {
        case expected: WriteDataOperation => expected must beEquivalentTo(actual)
      }
    }
  }

  "a delete data operation" should {
    "serde via xdr" >> prop { actual: DeleteDataOperation =>
      Operation.fromXDR(actual.toXDR) must beSuccessfulTry.like {
        case expected: DeleteDataOperation => expected must beEquivalentTo(actual)
      }
    }
  }

}