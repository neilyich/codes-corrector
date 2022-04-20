package neilyich.codes.codescorrector

import neilyich.correction.codes.channel.WordInfo
import neilyich.correction.codes.core.exceptions.DecodingException
import neilyich.correction.codes.core.words.SimpleWord
import neilyich.correction.codes.core.words.Word
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CodesCorrectorController {

    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping("/decode")
    fun decode(@RequestBody wordInfo: WordInfo<Boolean>): ResponseEntity<Word<*>> {
        return try {
            log.info("decoding: ${wordInfo.word}")
            val decoded = wordInfo.code.decode(wordInfo.word)
            log.info("decoded: $decoded")
            ResponseEntity.ok(decoded)
        } catch (e: DecodingException) {
            log.error("unable to decode word: ${wordInfo.word}", e)
            ResponseEntity.badRequest().body(SimpleWord(listOf("Unable to decode message: ${wordInfo.word}")))
        }
    }
}