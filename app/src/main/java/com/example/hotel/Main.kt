package com.example.hotel

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    println("호텔예약 프로그램 입니다.")
    println("메뉴")
    println("1. 방 예약, 2. 예약목록 출력, 3. 예약목록 (정렬) 출력, 4. 시스템 종료, 5. 금액 입급.출금 내역 목록 출력, 6. 예약 변경/취소")
    var number = readLine()!!.toInt()
    var now = LocalDate.now() // 현재 날짜
    val dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd") //날짜를 원하는 형식으로 문자열로 변환

    when(number) {
        1 -> {
            val randomResvMoney = (10000..50000).random()
            println("예약자 분의 성함을 입력해주세요.")
            var name = readLine()!!.toString()

            while (true) {
                println("예약할 방번호를 입력해주세요.")
                var room = readLine()!!.toInt()

                if (room in 100..999) {
                    break
                } else {
                    println("올바르지 않은 방번호 입니다. 방번호는 100~999 영역 이내입니다.")
                    continue
                }
            }

            var checkIn: LocalDate? = null
            while (true) {
                println("체크인 날짜를 입력해주세요. 표기형식) 20230631")

                val checkDate = readln()
                val temp = LocalDate.from(dateFormat.parse(checkDate))
                if (temp.isBefore(LocalDate.now())) {
                    println("체크인 지난 날은 선택할 수 없습니다.")
                    continue

                } else{
                    checkIn = temp
                    break
                }

            }
            var checkOut: LocalDate? = null
                while (true) {
                    println("체크아웃 날짜를 입력해주세요. 표기형식) 20230631")
                    val checkDate = readln()
                    val temp = LocalDate.from(dateFormat.parse(checkDate))
                    if (temp.isBefore(checkIn) || temp.isEqual(checkIn)) {
                        println("체크인 날짜보다 이전이거나 같을 수는 없습니다.")
                        continue
                    } else {
                        //사용자가 유효한 체크아웃 날짜를 입력한 경우, 그 날짜를 checkOut 변수에 저장
                        checkOut = temp
                        break

                    }
                }

//            if (people.money.outBalance(randomResvMoney, "reserve")) {
//                ResvHistory(
//                    people = people,
//                    checkIn = checkIn!!,
//                    checkOut = checkOut!!,
//                    reserveRoom = roomNum,
//                    resvMoney = randomResvMoney
//                ).run {
//                    resvHistory.add(this)
//                }
                    println("호텔 예약이 완료되었습니다.")


        }
    }
}