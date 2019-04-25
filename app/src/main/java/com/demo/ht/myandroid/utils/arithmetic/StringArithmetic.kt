package com.demo.ht.myandroid.utils.arithmetic

import android.content.Context
import com.demo.ht.myandroid.utils.LogUtils

/**
 * Created by huangtuo on 2018/8/21.
 */
object StringArithmetic {

    //按start、end索引反转 CharArray
    fun revarsalChar(chars: CharArray, start: Int,end: Int): CharArray{
        var start = start
        var end = end
        if(chars == null || end >= chars.size || start >= end){
            return chars
        }
        while (start < end){
            //首尾字符互换，直到替换完成
            var temp: Char = chars[start]
            chars[start] = chars[end]
            chars[end] = temp
            var i = 0
            i++
            start++
            end--
        }
        return chars
    }

    //按指定字符串 去反转原字符串
    fun revarsalString(sentence: String?, division: String): String?{
        if(sentence == null || sentence.isEmpty()){
            return sentence
        }
        var length = sentence.length
        var chars = revarsalChar(sentence.toCharArray(), 0 , length - 1)
        LogUtils.d(String(chars))
        //翻转每一个单词
        //
        var start = 0
        var end = 0
        while (start < length){
            if (chars[start].toString() == division){
                //遇到空格 向右继续查找
                start++
                end++
            }else if(end == length || chars[end].toString() == division){
                chars = revarsalChar(chars, start, end - 1)
                start = end++
            }else{
                //end+1，为了检查单词是否结束
                end++
            }
        }

        return String(chars)
    }

    //奇数在前，偶数在后
    fun oddFront(nums: IntArray): IntArray{
        if(nums == null || nums.size <= 1){
            return nums
        }
        var start = 0
        var end = nums.size - 1
        while (start < end){
            if(isOdd(nums[start])){
                start++  //奇数，索引右移
            }else if(!isOdd(nums[end])){
                end-- //偶数 左移
            }else{
                //奇偶互换
                var temp = nums[start]
                nums[start] = nums[end]
                nums[end] = temp
                start++
                end--
            }
        }
        return nums
    }

    //与1做按位运算，不为0就是奇数，反之偶数
    fun isOdd(n: Int): Boolean{
        return n and 1 != 0
    }


}