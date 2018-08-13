/*
 * Copyright 2017 TEAM PER LA TRASFORMAZIONE DIGITALE
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     ***REMOVED***://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ***REMOVED***.dataset

trait DownloadMethod

case object QuickDownloadMethod extends DownloadMethod

case object BatchDownloadMethod extends DownloadMethod

object DownloadMethods {

  def unapply(s: String): Option[DownloadMethod] = s match {
    case "quick" | "fast" | "direct" => Some { QuickDownloadMethod }
    case "batch" | "slow" | "export" => Some { BatchDownloadMethod }
    case _                           => None
  }

}