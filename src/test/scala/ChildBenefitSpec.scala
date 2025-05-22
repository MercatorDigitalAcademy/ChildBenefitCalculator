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
        val result = ChildBenefit.calculateWeeklyAmount(family, income)
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
        val result = ChildBenefit.calculateWeeklyAmount(family, income)
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
        val family = List(child1, child2)
        val income = 75000
        val result = ChildBenefit.calculateWeeklyAmount(family, income)
        val expectedResult = 11.54
        result shouldBe expectedResult
      }
    }
  }
}

