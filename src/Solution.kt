class Solution {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = listOf(284,287,289,293,295,298,0,3,8,9,10,11,12,15,17,19,20,22,26,29,30,31,35,36,37,38,42,43,45,50,51,54,56,58,59,60,62,63,68,70,73,74,81,83,84,87,92,95,99,101,102,105,108,109,112,114,115,116,122,125,126,127,129,132,134,136,137,138,139,147,149,152,153,154,155,159,160,161,163,164,165,166,168,169,171,172,174,176,177,180,187,188,190,191,192,198,200,203,204,206,207,209,210,212,214,216,221,224,227,228,229,230,233,235,237,241,242,243,244,246,248,252,253,255,257,259,260,261,262,265,266,268,269,270,271,272,273,277,279,281)
            println(search(nums.toIntArray(), 235))
        }

        fun search(nums: IntArray, target: Int): Int {
            var pivot: Int
            var split = 0
            var left = 0
            var right = nums.size - 1
            var hasFound = false

            if(nums[right] < nums[left]){
                loop@ while(left <= right){
                    split = left + (right - left) /2
                    val numSplit = nums[split]
                    when {
                        target == numSplit -> return split
                        split > 0 && numSplit < nums[split- 1]-> {
                            hasFound = true
                            break@loop
                        }
                        split < nums.size - 1 && numSplit > nums[split + 1]-> {
                            hasFound = true
                            split += 1
                            break@loop
                        }
                        else -> right = split - 1
                    }
                }

                if(!hasFound){
                    left = 0
                    right = nums.size - 1

                    loop@ while(left <= right){
                        split = left + (right - left) /2
                        val numSplit = nums[split]
                        when {
                            target == numSplit -> return split
                            split > 0 && numSplit < nums[split- 1]-> {
                                hasFound = true
                                break@loop
                            }
                            split < nums.size - 1 && numSplit > nums[split + 1]-> {
                                hasFound = true
                                split += 1
                                break@loop
                            }
                            else -> left = split + 1
                        }
                    }
                }

                if(hasFound){
                    left = split
                    right = nums.size - 1

                    while(left <= right){
                        pivot = left + (right - left) /2
                        when {
                            nums[pivot] == target -> return pivot
                            target < nums[pivot] -> right = pivot - 1
                            else -> left = pivot +1
                        }
                    }

                    if(split>0){
                        left = 0
                        right = split - 1
                        while(left <= right){
                            pivot = left + (right - left) /2
                            when {
                                nums[pivot] == target -> return pivot
                                target < nums[pivot] -> right = pivot - 1
                                else -> left = pivot +1
                            }
                        }
                    }
                }
            }
            else{
                while(left <= right){
                    pivot = left + (right - left) /2
                    when {
                        nums[pivot] == target -> return pivot
                        target < nums[pivot] -> right = pivot - 1
                        else -> left = pivot +1
                    }
                }
            }

            return -1
        }
    }


}


