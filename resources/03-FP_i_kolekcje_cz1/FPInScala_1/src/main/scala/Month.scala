package org.fpinscala

enum Month(name: String, ordinal: Int) {
  case January extends Month("Jan", 1)
  case February extends Month("Feb", 2)
  case March extends Month("Mar", 3)
  case April extends Month("Apr", 4)
  case May extends Month("May", 5)
  case June extends Month("Jun", 6)
  case July extends Month("Jul", 7)
  case August extends Month("Aug", 8)
  case September extends Month("Sep", 9)
  case October extends Month("Oct", 10)
  case November extends Month("Nov", 11)
  case December extends Month("Dec", 12)
}

