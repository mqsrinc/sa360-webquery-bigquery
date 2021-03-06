// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package dswebquerytobigquery;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.storage.Storage;

/** Factory to build Google Cloud Storage client. */
public interface StorageServiceFactory {

  static StorageServiceFactory getDefaultInstance() {
    return (credential) -> new Storage.Builder(
        new NetHttpTransport(),
        new JacksonFactory(),
        credential)
        .setApplicationName(Constants.APPLICATION_NAME)
        .build();
  }

  Storage buildStorageService(Credential credential);
}
