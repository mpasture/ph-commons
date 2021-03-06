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
package com.helger.commons.collection.multimap;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.annotation.ReturnsMutableCopy;

/**
 * Multi map based on {@link java.util.TreeMap} and
 * {@link java.util.LinkedHashSet} values.<br>
 *
 * @author Philip Helger
 * @param <KEYTYPE>
 *        key type
 * @param <VALUETYPE>
 *        value type
 */
@NotThreadSafe
public class MultiTreeMapLinkedHashSetBased <KEYTYPE, VALUETYPE>
                                            extends AbstractMultiTreeMapSetBased <KEYTYPE, VALUETYPE>
{
  public MultiTreeMapLinkedHashSetBased ()
  {}

  public MultiTreeMapLinkedHashSetBased (@Nullable final Comparator <? super KEYTYPE> aComparator)
  {
    super (aComparator);
  }

  public MultiTreeMapLinkedHashSetBased (@Nonnull final KEYTYPE aKey, @Nullable final VALUETYPE aValue)
  {
    super (aKey, aValue);
  }

  public MultiTreeMapLinkedHashSetBased (@Nullable final KEYTYPE aKey, @Nullable final Set <VALUETYPE> aCollection)
  {
    super (aKey, aCollection);
  }

  public MultiTreeMapLinkedHashSetBased (@Nullable final Map <? extends KEYTYPE, ? extends Set <VALUETYPE>> aCont)
  {
    super (aCont);
  }

  @Override
  @Nonnull
  @ReturnsMutableCopy
  protected final Set <VALUETYPE> createNewCollection ()
  {
    return new LinkedHashSet <VALUETYPE> ();
  }
}
