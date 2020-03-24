class Solution:
    def intToRoman(self, num: int) -> str:
        one = ["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"]
        two = ["", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"]
        three = ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"]
        four = ["", "M", "MM", "MMM"]
        return four[num // 1000] + three[(num % 1000) // 100] + two[(num % 100) // 10] + one[num % 10]
