package ChildBenefit

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ChildBenefitSpec extends AnyWordSpec with Matchers {  
  "isChildEligible" should {    
    "return true" when {      
      "child is younger than 16"in {   
        val child = ChildInFamily(age=15, inEducation = true, isDisabled = false)        
        val result = ChildBenefit.isChildEligible(child)        
        val expectedResult = true        
        result shouldBe expectedResult      
      }    
    }  
  }
  "TC01" should {
    "return £60.55" when {
      "income is £30,000 and the children are 18 in AE, 15, and 8" in {
        val child1 = ChildInFamily(age = 18, inEducation = true, isDisabled = false)
        val child2 = ChildInFamily(age = 15, inEducation = false, isDisabled = false)
        val child3 = ChildInFamily(age = 8, inEducation = false, isDisabled = false)
        val family = List(child1, child2, child3)
        val income = 30000
        val result = ChildBenefit.finalTotalValue(family, income)
        val expectedResult = 60.55
        result shouldBe expectedResult
      }
    }
  }
  "TC02" should {
    "return £2.88" when {
      "income is £55,000 and the children are 20 and 15" in {
        val child1 = ChildInFamily(age = 20, inEducation = false, isDisabled = false)
        val child2 = ChildInFamily(age = 15, inEducation = false, isDisabled = false)
        val family = List(child1, child2)
        val income = 55000
        val result = ChildBenefit.finalTotalValue(family, income)
        val expectedResult = 2.88
        result shouldBe expectedResult
      }
    }
  }
  "TC03" should {
    "return £11.54" when {
      "income is £75,000 and the children are 18 not in AE, 16 in AE and 13" in {
        val child1 = ChildInFamily(age = 18, inEducation = false, isDisabled = false)
        val child2 = ChildInFamily(age = 16, inEducation = true, isDisabled = false)
        val child3 = ChildInFamily(age = 13, inEducation = false, isDisabled = false)
        val family = List(child1, child2, child3)
        val income = 75000
        val result = ChildBenefit.finalTotalValue(family, income)
        val expectedResult = 11.54
        result shouldBe expectedResult
      }
    }
  }
  "TC04" should {
    "return £0" when {
      "income is £200,000 and the child is 6" in {
        val child1 = ChildInFamily(age = 6, inEducation = false, isDisabled = false)
        val family = List(child1)
        val income = 200000
        val result = ChildBenefit.finalTotalValue(family, income)
        val expectedResult = 0
        result shouldBe expectedResult
      }
    }
  }
  "TC05" should {
    "return £102.75" when {
      "income is £50,000 and the children are 15, 13, 11 with SC, 9 and 7 with SC" in {
        val child1 = ChildInFamily(age = 15, inEducation = false, isDisabled = false)
        val child2 = ChildInFamily(age = 13, inEducation = false, isDisabled = false)
        val child3 = ChildInFamily(age = 11, inEducation = false, isDisabled = true)
        val child4 = ChildInFamily(age = 9, inEducation = false, isDisabled = false)
        val child5 = ChildInFamily(age = 7, inEducation = false, isDisabled = true)
        val family = List(child1, child2, child3, child4, child5)
        val income = 50000
        val result = ChildBenefit.finalTotalValue(family, income)
        val expectedResult = 102.75
        result shouldBe expectedResult
      }
    }
  }
  "TC06" should {
    "return £6.73" when {
      "income is £100,000 and the child is 5 with SC" in {
        val child1 = ChildInFamily(age = 5, inEducation = false, isDisabled = true)
        val family = List(child1)
        val income = 100000
        val result = ChildBenefit.finalTotalValue(family, income)
        val expectedResult = 6.73
        result shouldBe expectedResult
      }
    }
  }
  "TC07" should {
    "return £28.86" when {
      "income is £90,000 and the children are 8 with SC, 4 with SC and 1 with SC" in {
        val child1 = ChildInFamily(age = 15, inEducation = false, isDisabled = true)
        val child2 = ChildInFamily(age = 13, inEducation = false, isDisabled = true)
        val child3 = ChildInFamily(age = 11, inEducation = false, isDisabled = true)
        val family = List(child1, child2, child3)
        val income = 90000
        val result = ChildBenefit.finalTotalValue(family, income)
        val expectedResult = 28.86
        result shouldBe expectedResult
      }
    }
  }
  "calculateYearlyAmountEldest" should {
    "return 1354.6" when {
      "invoked" in {
        val result = ChildBenefit.calculateYearlyAmountEldest()
        val expectedResult = 1354.6
        result shouldBe expectedResult
      }
    }
  }
  "calculateYearlyAmountFurtherChild" should {
    "return 897" when {
      "invoked" in {
        val result = ChildBenefit.calculateYearlyAmountFurtherChild()
        val expectedResult = 897.0
        result shouldBe expectedResult
      }
    }
  }
}

