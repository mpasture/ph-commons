/**
 * Copyright (C) 2014-2016 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.commons.lang.priviledged;

import java.security.PrivilegedAction;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.ValueEnforcer;

/**
 * A special privileged object, that calls
 * <code>Thread.currentThread ().setContextClassLoader (ClassLoader)</code>
 *
 * @author Philip Helger
 */
public final class PrivilegedActionSetContextClassLoader implements PrivilegedAction <Object>
{
  private final ClassLoader m_aClassLoader;

  public PrivilegedActionSetContextClassLoader (@Nonnull final ClassLoader aClassLoader)
  {
    m_aClassLoader = ValueEnforcer.notNull (aClassLoader, "ClassLoader");
  }

  @Nullable
  public Object run ()
  {
    Thread.currentThread ().setContextClassLoader (m_aClassLoader);
    return null;
  }
}
