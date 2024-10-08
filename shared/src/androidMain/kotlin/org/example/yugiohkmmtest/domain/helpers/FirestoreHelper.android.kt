package org.example.yugiohkmmtest.domain.helpers

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

actual class FirestoreHelper {
    private val firestore = FirebaseFirestore.getInstance()

    actual suspend fun addDocument(
        collection: String,
        data: Map<String, Any>
    ) {
        firestore.collection(collection).add(data).await()

    }

    actual suspend fun getDocument(
        collection: String,
        documentId: String
    ): Map<String, Any>? {
        val documentSnapshot = firestore.collection(collection).document(documentId).get().await()
        return documentSnapshot.data
    }
}