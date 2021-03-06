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
package com.helger.commons.id.factory;

import javax.annotation.Nonnull;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.hashcode.HashCodeGenerator;
import com.helger.commons.string.ToStringGenerator;

/**
 * An {@link IStringIDFactory} implementation that uses a constant prefix and a
 * long supplied from {@link GlobalIDFactory#getNewLongID()} to create unique
 * IDs.
 *
 * @author Philip Helger
 */
public class StringIDFromGlobalLongIDFactory implements IStringIDFactory
{
  private final String m_sPrefix;

  public StringIDFromGlobalLongIDFactory ()
  {
    this (GlobalIDFactory.DEFAULT_PREFIX);
  }

  public StringIDFromGlobalLongIDFactory (@Nonnull final String sPrefix)
  {
    m_sPrefix = ValueEnforcer.notNull (sPrefix, "Prefix");
  }

  @Nonnull
  public String getPrefix ()
  {
    return m_sPrefix;
  }

  @Nonnull
  public String getNewID ()
  {
    return m_sPrefix + Long.toString (GlobalIDFactory.getNewLongID ());
  }

  @Override
  public boolean equals (final Object o)
  {
    if (o == this)
      return true;
    if (o == null || !getClass ().equals (o.getClass ()))
      return false;
    final StringIDFromGlobalLongIDFactory rhs = (StringIDFromGlobalLongIDFactory) o;
    return m_sPrefix.equals (rhs.m_sPrefix);
  }

  @Override
  public int hashCode ()
  {
    return new HashCodeGenerator (this).append (m_sPrefix).getHashCode ();
  }

  @Override
  public String toString ()
  {
    return new ToStringGenerator (this).append ("prefix", m_sPrefix).toString ();
  }
}
