/**
 * Copyright (c) 2015-present, Facebook, Inc.
 * <p>
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.ldroid.kwei.progress;

import okhttp3.RequestBody;

public class RequestBodyUtil {

    public static ProgressRequestBody createProgressRequest(
            RequestBody requestBody,
            ProgressListener listener) {
        return new ProgressRequestBody(requestBody, listener);
    }


}
