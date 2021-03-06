package net.squanchy.service.firebase.injection

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import net.squanchy.injection.ApplicationLifecycle
import net.squanchy.service.firebase.FirebaseAuthService
import net.squanchy.service.firebase.FirestoreDbService
import net.squanchy.service.repository.AuthService

@Module
class FirestoreModule {

    @Provides
    internal fun firebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    internal fun firebaseFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @ApplicationLifecycle
    internal fun firestoreDbService(database: FirebaseFirestore): FirestoreDbService = FirestoreDbService(database)

    @ApplicationLifecycle
    @Provides
    internal fun firebaseAuthService(firebaseAuth: FirebaseAuth): AuthService = FirebaseAuthService(firebaseAuth)
}
