package org.example.yugiohkmmtest.domain.helpers

actual class FirestoreHelper {
    private val firestore: FIRFirestore = FIRFirestore.firestore()

    actual suspend fun addDocument(
        collection: String,
        data: Map<String, Any>
    ) {
    }

    actual suspend fun getDocument(
        collection: String,
        documentId: String
    ): Map<String, Any>? {
        TODO("Not yet implemented")
    }
}