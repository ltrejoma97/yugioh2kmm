package org.example.yugiohkmmtest.domain.helpers

expect class FirestoreHelper {
    suspend fun addDocument(collection: String, data: Map<String, Any>)
    suspend fun getDocument(collection: String, documentId: String): Map<String, Any>?
}