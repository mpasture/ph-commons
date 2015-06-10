/**
 * Copyright (C) 2014-2015 Philip Helger (www.helger.com)
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
package com.helger.commons.text;

import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.DevelopersNote;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.callback.CallbackList;
import com.helger.commons.callback.IChangeCallback;
import com.helger.commons.hashcode.HashCodeGenerator;
import com.helger.commons.locale.LocaleCache;
import com.helger.commons.state.EChange;
import com.helger.commons.string.ToStringGenerator;

/**
 * This class represents a thread safe multilingual text. It wraps an existing
 * MultiLingualText and adds a read write lock around it.
 *
 * @author Philip Helger
 */
@ThreadSafe
public class MultilingualTextThreadSafe implements IMutableMultilingualText
{
  protected final ReadWriteLock m_aRWLock = new ReentrantReadWriteLock ();
  private final MultilingualText m_aMLT;

  public MultilingualTextThreadSafe ()
  {
    m_aMLT = new MultilingualText ();
  }

  /**
   * Constructor especially for the static TextProvider.createXXX methods
   *
   * @param aSimpleMLT
   *        The simple multi lingual text to use.
   */
  public MultilingualTextThreadSafe (@Nonnull final ISimpleMultilingualText aSimpleMLT)
  {
    ValueEnforcer.notNull (aSimpleMLT, "SimpleMLT");

    // Create a copy of the multilingual text!
    m_aMLT = new MultilingualText (aSimpleMLT);
  }

  public MultilingualTextThreadSafe (@Nonnull final IMultilingualText aMLT)
  {
    ValueEnforcer.notNull (aMLT, "MLT");

    // Create a copy of the multilingual text!
    m_aMLT = new MultilingualText (aMLT);
  }

  @Nullable
  public String getText (@Nonnull final Locale aContentLocale)
  {
    m_aRWLock.readLock ().lock ();
    try
    {
      return m_aMLT.getText (aContentLocale);
    }
    finally
    {
      m_aRWLock.readLock ().unlock ();
    }
  }

  @Nullable
  @Deprecated
  @DevelopersNote ("Use getText instead")
  public String getTextWithArgs (@Nonnull final Locale aContentLocale)
  {
    return getText (aContentLocale);
  }

  @Nullable
  public String getTextWithArgs (@Nonnull final Locale aContentLocale, @Nullable final Object... aArgs)
  {
    m_aRWLock.readLock ().lock ();
    try
    {
      return m_aMLT.getTextWithArgs (aContentLocale, aArgs);
    }
    finally
    {
      m_aRWLock.readLock ().unlock ();
    }
  }

  @Nonnull
  public EChange addText (@Nonnull final Locale aContentLocale, @Nullable final String sText)
  {
    m_aRWLock.writeLock ().lock ();
    try
    {
      return m_aMLT.addText (aContentLocale, sText);
    }
    finally
    {
      m_aRWLock.writeLock ().unlock ();
    }
  }

  @Nonnull
  public EChange setText (@Nonnull final Locale aContentLocale, @Nullable final String sText)
  {
    m_aRWLock.writeLock ().lock ();
    try
    {
      return m_aMLT.setText (aContentLocale, sText);
    }
    finally
    {
      m_aRWLock.writeLock ().unlock ();
    }
  }

  @Nonnegative
  public int getLocaleCount ()
  {
    m_aRWLock.readLock ().lock ();
    try
    {
      return m_aMLT.getLocaleCount ();
    }
    finally
    {
      m_aRWLock.readLock ().unlock ();
    }
  }

  public boolean containsLocale (@Nullable final Locale aContentLocale)
  {
    m_aRWLock.readLock ().lock ();
    try
    {
      return m_aMLT.containsLocale (aContentLocale);
    }
    finally
    {
      m_aRWLock.readLock ().unlock ();
    }
  }

  public boolean containsLocaleWithFallback (@Nullable final Locale aContentLocale)
  {
    m_aRWLock.readLock ().lock ();
    try
    {
      return m_aMLT.containsLocaleWithFallback (aContentLocale);
    }
    finally
    {
      m_aRWLock.readLock ().unlock ();
    }
  }

  @Nonnull
  @ReturnsMutableCopy
  public Map <Locale, String> getAllTexts ()
  {
    m_aRWLock.readLock ().lock ();
    try
    {
      return m_aMLT.getAllTexts ();
    }
    finally
    {
      m_aRWLock.readLock ().unlock ();
    }
  }

  @Nonnegative
  public int getSize ()
  {
    m_aRWLock.readLock ().lock ();
    try
    {
      return m_aMLT.getSize ();
    }
    finally
    {
      m_aRWLock.readLock ().unlock ();
    }
  }

  public boolean isEmpty ()
  {
    m_aRWLock.readLock ().lock ();
    try
    {
      return m_aMLT.isEmpty ();
    }
    finally
    {
      m_aRWLock.readLock ().unlock ();
    }
  }

  @Nonnull
  @ReturnsMutableCopy
  public Set <Locale> getAllLocales ()
  {
    m_aRWLock.readLock ().lock ();
    try
    {
      return m_aMLT.getAllLocales ();
    }
    finally
    {
      m_aRWLock.readLock ().unlock ();
    }
  }

  @Nonnull
  public EChange removeText (@Nonnull final Locale aContentLocale)
  {
    m_aRWLock.writeLock ().lock ();
    try
    {
      return m_aMLT.removeText (aContentLocale);
    }
    finally
    {
      m_aRWLock.writeLock ().unlock ();
    }
  }

  @Nonnull
  public EChange clear ()
  {
    m_aRWLock.writeLock ().lock ();
    try
    {
      return m_aMLT.clear ();
    }
    finally
    {
      m_aRWLock.writeLock ().unlock ();
    }
  }

  @Nonnull
  public EChange assignFrom (@Nonnull final IMultilingualText aMLT)
  {
    m_aRWLock.writeLock ().lock ();
    try
    {
      return m_aMLT.assignFrom (aMLT);
    }
    finally
    {
      m_aRWLock.writeLock ().unlock ();
    }
  }

  @Nonnull
  @ReturnsMutableObject (reason = "design")
  public CallbackList <IChangeCallback <IMutableMultilingualText>> getChangeNotifyCallbacks ()
  {
    m_aRWLock.writeLock ().lock ();
    try
    {
      return m_aMLT.getChangeNotifyCallbacks ();
    }
    finally
    {
      m_aRWLock.writeLock ().unlock ();
    }
  }

  @Override
  public boolean equals (final Object o)
  {
    if (o == this)
      return true;
    if (o == null || !getClass ().equals (o.getClass ()))
      return false;
    final MultilingualTextThreadSafe rhs = (MultilingualTextThreadSafe) o;
    return m_aMLT.equals (rhs.m_aMLT);
  }

  @Override
  public int hashCode ()
  {
    return new HashCodeGenerator (this).append (m_aMLT).getHashCode ();
  }

  @Override
  public String toString ()
  {
    return new ToStringGenerator (this).append ("mlt", m_aMLT).toString ();
  }

  @Nonnull
  public static IMutableMultilingualText createFromMap (@Nonnull final Map <String, String> aMap)
  {
    final IMutableMultilingualText ret = new MultilingualTextThreadSafe ();
    for (final Entry <String, String> aEntry : aMap.entrySet ())
    {
      final String sText = aEntry.getValue ();
      if (sText != null)
        ret.setText (LocaleCache.getLocale (aEntry.getKey ()), sText);
    }
    return ret;
  }
}