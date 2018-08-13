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

package modules

import controllers.WithSecurityInfoApiHelpController
import play.api.inject.{Binding, Module}
import play.api.{Configuration, Environment}
import play.modules.swagger.SwaggerPlugin

class WithSecurityInfoSwaggerModule extends Module {

  override def bindings(***REMOVED***ironment: Environment, configuration: Configuration): Seq[Binding[_]] = Seq(
    bind[SwaggerPlugin].to[WithSecurityInfoSwaggerPluginImpl].eagerly(),
    bind[WithSecurityInfoApiHelpController].toSelf.eagerly()
  )

}